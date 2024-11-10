package com.mock.paymentGateway.models;

import java.time.LocalDate;

/**
 * @author arsharma 
 */
public class CardPaymentMethodExpiry {

    private int year;
    private int month;

    public CardPaymentMethodExpiry() {

    }

    public CardPaymentMethodExpiry(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Method to check if card expiry is before today
     * @return boolean
     */
    public boolean isNotExpired() {
        // Get the current year and month
        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();
        int currentMonth = today.getMonthValue();

        // Compare year and month with current year and month
        if (this.year > currentYear) {
            return true; // Expired if the year is less than the current year
        } else if (this.year == currentYear && this.month > currentMonth) {
            return true; // Expired if same year but the month is earlier
        } else {
            return false; // Not expired
        }
    }
}
