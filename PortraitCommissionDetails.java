public class PortraitCommissionDetails extends CommissionDetails {

    public PortraitCommissionDetails(String artistName, double price, String status) {
        super(artistName, "Portrait Art", price, status);
        customizeDetails();
        setVisible(true);
    }

    @Override
    protected void customizeDetails() {
        commissionTypeLabel.setText(commissionTypeLabel.getText() + " (Portrait Specialist)");
    }
}