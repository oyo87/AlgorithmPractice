SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10' AND
CAR_ID IN(
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
    GROUP BY CAR_ID
    HAVING 5 <= COUNT(CAR_ID)
)
GROUP BY CAR_ID, MONTH(START_DATE)
HAVING 1 <= RECORDS 
ORDER BY MONTH, CAR_ID DESC