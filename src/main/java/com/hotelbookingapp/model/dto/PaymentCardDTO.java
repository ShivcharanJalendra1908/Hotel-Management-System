package com.hotelbookingapp.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCardDTO {

    @NotBlank(message = "Cardholder name cannot be empty")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Cardholder name must contain only letters and spaces")
    @Size(min = 3, max = 50, message = "Cardholder name should be between 3 and 50 characters")
    private String cardholderName;

    @Pattern(regexp = "^\\d{16}$", message = "Card number be 16 digits")
    private String cardNumber;

    private String expirationDate;

    @Pattern(regexp = "^\\d{3}$", message = "CVC must be 3 digits")
    private String cvc;
}
