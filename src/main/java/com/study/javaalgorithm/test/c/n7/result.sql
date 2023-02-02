SELECT *
FROM (SELECT name AS NAME, COUNT(name) AS CART_COUNT
      FROM (SELECT * FROM cart_products GROUP BY CART_ID, NAME) grouping_cart
      GROUP BY name
      ORDER BY CART_COUNT DESC, name
     ) grouping_name
    LIMIT 1
;

