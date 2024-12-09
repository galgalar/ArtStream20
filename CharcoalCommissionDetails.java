public class CharcoalCommissionDetails extends CommissionDetails {

    public CharcoalCommissionDetails(String artistName, double price, String status) {
        super(artistName, "Charcoal Art", price, status);
        customizeDetails();
        setVisible(true);
    }

    @Override
    protected void customizeDetails() {
        commissionTypeLabel.setText(commissionTypeLabel.getText() + " (Charcoal Specialization)");
    }
}