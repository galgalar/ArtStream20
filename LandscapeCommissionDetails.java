public class LandscapeCommissionDetails extends CommissionDetails {

    public LandscapeCommissionDetails(String artistName, double price, String status) {
        super(artistName, "Landscape Art", price, status);
        customizeDetails();
        setVisible(true);
    }

    @Override
    protected void customizeDetails() {
        commissionTypeLabel.setText(commissionTypeLabel.getText() + " (Landscape Expert)");
    }
}