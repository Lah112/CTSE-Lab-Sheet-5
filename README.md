CTSE Lab Sheet 5

Chamara R M L K~IT22076816
======================================================================================
Postman

ITEM SERVICE ENDPOINTS

1. GET All Items
Method: GET
URL: http://localhost:8080/items

2. GET Item by ID
Method: GET
URL: http://localhost:8080/items/1

3. POST Create New Item
Method: POST
URL: http://localhost:8080/items
Headers: Content-Type: application/json
Body (raw JSON):

{
    "name": "Laptop",
    "price": 999.99,
    "category": "Electronics"
}
-----------------------------------------------------------------------------------------

ORDER SERVICE ENDPOINTS

4. GET All Orders
Method: GET
URL: http://localhost:8080/orders

5. GET Order by ID
Method: GET
URL: http://localhost:8080/orders/1

6. POST Create New Order
Method: POST
URL: http://localhost:8080/orders
Headers: Content-Type: application/json
Body (raw JSON):

{
    "item": "Laptop",
    "quantity": 2,
    "customerId": "C001"
}
-----------------------------------------------------------------------------------------
PAYMENT SERVICE ENDPOINTS

7. GET All Payments
Method: GET
URL: http://localhost:8080/payments


8. GET Payment by ID
Method: GET
URL: http://localhost:8080/payments/1

9. POST Process Payment
Method: POST
URL: http://localhost:8080/payments/process
Headers: Content-Type: application/json
Body (raw JSON):

{
    "orderId": 1,
    "amount": 1299.99,
    "method": "CARD"
}
