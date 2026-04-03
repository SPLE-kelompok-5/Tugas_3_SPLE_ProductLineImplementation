package aisco.donation.directpayment;

import aisco.donation.core.DonationComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class DonationImpl extends DonationComponent {
    List<Object> donationList;

    public DonationImpl() {
        System.out.println("\nDonation via Direct Payment");
        donationList = new ArrayList<>();
    }

    public DonationImpl(String name, String email, String phone, int amount, String paymentMethod) {
        super(name, email, phone, amount, paymentMethod);
    }

    public void addDonation() {
        donationList.add(new DonationImpl("Rina Susanti", "rina@mail.com", "+62812 1111 2222", 1000000, "Direct Transfer"));
        donationList.add(new DonationImpl("Hendra Wijaya", "hendra@mail.com", "+62813 3333 4444", 750000, "Direct Cash"));
        donationList.add(new DonationImpl("Putri Lestari", "putri@mail.com", "+62814 5555 6666", 500000, "Direct Transfer"));
    }

    public void getDonation() {
        System.out.println(Arrays.asList(donationList));
    }

    public String toString() {
        return "- Donasi Direct " + name + ": " + amount + " Payment Method: " + paymentMethod + "\n";
    }
}
