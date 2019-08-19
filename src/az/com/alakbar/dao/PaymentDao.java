package az.com.alakbar.dao;

import az.com.alakbar.model.Payment;

import java.util.List;

public interface PaymentDao {

    List<Payment> getPaymentList() throws Exception;
    boolean addPayment(Payment payment) throws Exception;
}
