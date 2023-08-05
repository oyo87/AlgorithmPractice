SELECT floor(PRICE / 10000) * 10000 AS PRICE_GROUP, COUNT(PRICE) AS PRODUCTS
FROM PRODUCT
GROUP BY floor(PRICE / 10000) * 10000
ORDER BY PRICE_GROUP