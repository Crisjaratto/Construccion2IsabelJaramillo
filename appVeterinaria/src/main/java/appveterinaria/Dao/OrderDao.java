package appveterinaria.Dao;

import appveterinaria.Dto.OrderDto;

public interface OrderDao {
    
    public OrderDto createOrden (OrderDto orderDto)throws Exception;
    public OrderDto orderById (long orderId)throws Exception;
}
