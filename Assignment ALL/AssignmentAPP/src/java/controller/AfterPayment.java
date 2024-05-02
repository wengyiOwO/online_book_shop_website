package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Driver;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import model.Cart;
import model.CartService;
import model.OrderHistory;
import model.OrderHistoryService;
import model.Orders;
import model.OrdersService;
import model.Payment;
import model.PaymentService;
import model.Shipping;
import model.ShippingService;
import model.TransactionService;
import model.Transactions;
import model.Users;

/**
 *
 * @author louis
 */
public class AfterPayment extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            OrdersService orderService = new OrdersService(em);
            List<Orders> orderList = orderService.findAll();
            PaymentService paymentService = new PaymentService(em);
                List<Payment> paymentList = paymentService.findAll();
            double total = Double.parseDouble(request.getParameter("total"));
            String paymentType = request.getParameter("paymentType");

            String address =  (String) session.getAttribute("fullAddress");
            Users user = (Users) session.getAttribute("user");
            session.setAttribute("total", total);
            session.setAttribute("paymentType", paymentType);
            String nextOrderId ="";
            String nextPaymentId ="";

            try {//try Order exception
                
                if (!orderList.isEmpty()) {
                    Orders order = orderList.get(orderList.size() - 1);
                    String lastId = order.getOrderId();
                    int idNum = Integer.parseInt(lastId.substring(1));
                    nextOrderId = "O" + String.format("%04d", idNum + 1);
                } else {
                    nextOrderId = "O1001";
                }

                Date currentDate = new Date();
                java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
                Orders order = new Orders(nextOrderId, user, sqlDate);

                utx.begin();
                boolean sucessOrder = orderService.addOrder(order);//insert into Order
                utx.commit();
            } catch (Exception ex) {//catch Order exception
                PrintWriter out = response.getWriter();
                out.print(ex);
                System.out.println(ex);
            }
            //end of Order
            //order History Start
            Orders orderId = orderService.findOrderByOrderID(nextOrderId);
            try {
                OrderHistoryService orderHistoryService = new OrderHistoryService(em);
                
                CartService cartService = new CartService(em);
                List<Cart> cartList = (List<Cart>) cartService.findCartByUserId(user);
                String nextOrderHistoryId;
                for (Cart cart : cartList) {

                    List<OrderHistory> orderHistoryList = orderHistoryService.findAll();
                    // Id generation
                    if (!orderHistoryList.isEmpty()) {
                        OrderHistory orderHistory = orderHistoryList.get(orderHistoryList.size() - 1);
                        String lastId = orderHistory.getBookOrderId();
                        int idNum = Integer.parseInt(lastId.substring(1));
                        nextOrderHistoryId = "H" + String.format("%04d", idNum + 1);
                    } else {
                        nextOrderHistoryId = "H1001";
                    }

                    OrderHistory orderHistory = new OrderHistory();
                    orderHistory.setBookOrderId(nextOrderHistoryId);
                    orderHistory.setBookId(cart.getBookId());
                    orderHistory.setOrderId(orderId);
                    orderHistory.setQuantity(cart.getQuantity());

                    utx.begin();
                    boolean sucessOrderHistory = orderHistoryService.addOrderHistory(orderHistory);//Insert into Order History
                    utx.commit();  
                }
                // Loop through the list and delete each order
                for (Cart cart : cartList) {
                    utx.begin();
                    Cart mergedOrder = em.merge(cart); // Merge the detached entity
                    em.remove(mergedOrder);
                    utx.commit();
                }
//                boolean deleteCart = cartService.deleteCartbyUserId(user);//Delete cart since it is added to the Cart History

            } catch (Exception ex) {//catch OrderHistory Exception
                PrintWriter out = response.getWriter();
                out.print(ex);
                System.out.println(ex);
            }
            //end of Order History

            try {//insert into payment
                if (!paymentList.isEmpty()) {
                    Payment payment = paymentList.get(paymentList.size() - 1);
                    String lastId = payment.getPaymentId();
                    int idNum = Integer.parseInt(lastId.substring(1));
                    nextPaymentId = "P" + String.format("%04d", idNum + 1);
                } else {
                    nextPaymentId = "P1001";
                }

                Payment payment = new Payment();
                payment.setPaymentId(nextPaymentId);
                payment.setOrderId(orderId);
                payment.setTotal(total);
                payment.setPaymentMethod(paymentType);

                utx.begin();
                boolean sucessPayment = paymentService.addPayment(payment);//Insert into Payment
                utx.commit();
            } catch (Exception ex) {//catching error for payment
                PrintWriter out = response.getWriter();
                out.print(ex);
                System.out.println(ex);
            }
            //end of payment
            
            
            try{//insert into Shipping
                ShippingService shippingService = new ShippingService(em);
                List<Shipping> shippingList = shippingService.findAll();
                String nextShippingId;
                if (!shippingList.isEmpty()) {
                    Shipping shipping = shippingList.get(shippingList.size() - 1);
                    String lastId = shipping.getShippingId();
                    int idNum = Integer.parseInt(lastId.substring(1));
                    nextShippingId = "I" + String.format("%04d", idNum + 1);
                } else {
                    nextShippingId = "I1001";
                }
                Shipping shipping = new Shipping();
                shipping.setShippingId(nextShippingId);
                shipping.setOrderId(orderId);
                shipping.setAddress(address);
                shipping.setStatus("Processing");

                utx.begin();
                boolean sucessOrderHistory = shippingService.addShipping(shipping);//Insert into Payment
                utx.commit();
                
            }catch (Exception ex) {//catching error for shipping
                PrintWriter out = response.getWriter();
                out.print(ex);
                System.out.println(ex);
            }
            
            Payment paymentId = paymentService.findPaymentByPaymentId(nextPaymentId);
            try{//insert into Transaction
                TransactionService transactionService = new TransactionService(em);
                List<Transactions> transactionList = transactionService.findAll();
                String nextTransactionId;
                if (!transactionList.isEmpty()) {
                    Transactions transaction = transactionList.get(transactionList.size() - 1);
                    String lastId = transaction.getTransactionId();
                    int idNum = Integer.parseInt(lastId.substring(1));
                    nextTransactionId = "T" + String.format("%04d", idNum + 1);
                } else {
                    nextTransactionId = "T1001";
                }
                Transactions transaction = new Transactions();
                transaction.setTransactionId(nextTransactionId);
                transaction.setPaymentId(paymentId);

                utx.begin();
                boolean sucessTransaction = transactionService.addTransaction(transaction);//Insert into Payment
                utx.commit();
                
            }catch (Exception ex) {//catching error for transaction
                PrintWriter out = response.getWriter();
                out.print(ex);
                System.out.println(ex);
            }
            
//            session.setAttribute("sucess", sucess);
            response.sendRedirect("PaymentSuccess.jsp");
        } catch (Exception ex) {
            PrintWriter out = response.getWriter();
            out.print(ex);
            System.out.println(ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
