package appveterinaria.Validator;

public class InvoiceValidator extends InputsValidator {

    public long invoiceIdValidator(String number) throws Exception {
        return super.longValidator(number, "N° de la factura: ");
    }

    public int orderIdValidator(String number) throws Exception {
        return super.integerValidator(number, "N° de la orden: ");
    }

    public void productNameValidador(String productName) throws Exception {
        super.stringValidator(productName, "Nombre del producto: ");
    }

    public double valueValidator(String number, String element) throws Exception {
        return super.doubleValidator(number, "Valor: ");
    }

    public long quantityValidator(String number) throws Exception {
        return super.longValidator(number, "Cantidad: ");
    }
}
