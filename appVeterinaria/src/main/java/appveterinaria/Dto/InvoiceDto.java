package appveterinaria.Dto;

import java.sql.Date;

public class InvoiceDto {
    private long invoiceId;
    private PetDto petId;
    private PersonDto ownerId;
    private int orderId;
    private String productName;
    private double value;
    private int quantity;
    private Date date;

    public InvoiceDto(long invoiceId, PetDto petId, PersonDto ownerId, int orderId, String productName, int quantity, Date date) {
        this.invoiceId = invoiceId;
        this.petId = petId;
        this.ownerId = ownerId;
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.date = date;
    }

    public InvoiceDto(long invoiceId, PetDto petId, PersonDto ownerId, int orderId) {
        this.invoiceId = invoiceId;
        this.petId = petId;
        this.ownerId = ownerId;
        this.orderId = orderId;
    }

    
    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public PetDto getPetId() {
        return petId;
    }

    public void setPetId(PetDto petId) {
        this.petId = petId;
    }

    public PersonDto getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(PersonDto ownerId) {
        this.ownerId = ownerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
