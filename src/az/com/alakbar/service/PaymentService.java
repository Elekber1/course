package az.com.alakbar.service;

import az.com.alakbar.model.AdvancedSearch;
import az.com.alakbar.model.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getPaymentList() throws Exception;
    boolean addPayment(Payment payment) throws Exception;
    Payment getPaymentId(Long paymentId) throws Exception;
    boolean updatePayment(Payment  payment) throws Exception;
    List<Payment> searchPaymentData(String keyword) throws Exception;

    List<Payment> advancedSearchPaymentData(AdvancedSearch advancedSearch) throws Exception;

}
