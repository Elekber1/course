package az.com.alakbar.service.impl;

import az.com.alakbar.dao.PaymentDao;
import az.com.alakbar.model.AdvancedSearch;
import az.com.alakbar.model.Payment;
import az.com.alakbar.service.PaymentService;

import java.util.List;


public class PaymentServiceImpl implements PaymentService{


    private PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public List<Payment> getPaymentList() throws Exception {
        return paymentDao.getPaymentList();
    }

    @Override
    public boolean addPayment(Payment payment) throws Exception {
        return paymentDao.addPayment(payment);
    }

    @Override
    public Payment getPaymentId(Long paymentId) throws Exception {
        return paymentDao.getPaymentId(paymentId);
    }

    @Override
    public boolean updatePayment(Payment payment) throws Exception {
        return paymentDao.updatePayment(payment);
    }

    @Override
    public List<Payment> searchPaymentData(String keyword) throws Exception {
        return paymentDao.searchPaymentData(keyword);
    }

    @Override
    public List<Payment> advancedSearchPaymentData(AdvancedSearch advancedSearch) throws Exception {
        return paymentDao.advancedSearchPaymentData(advancedSearch);
    }
}
