package appveterinaria.Models;

import appveterinaria.Dto.InvoiceDto;
import appveterinaria.Dto.OrderDto;

public interface SellerService {
    
    public void checkOrder(OrderDto OrderDto) throws Exception;

    public void generateSalesInvoice(InvoiceDto InvoiceDto) throws Exception;
    
}
