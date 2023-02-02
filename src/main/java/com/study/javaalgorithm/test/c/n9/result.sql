SELECT
    id AS ID,
    IFNULL(total_amount, 0) AS TOTAL_PRICE
FROM game_users
         LEFT JOIN (
    SELECT
        user_id,
        SUM(amount) AS total_amount
    FROM payments
    GROUP BY user_id
) user_payments ON game_users.id = user_payments.user_id
ORDER BY id;
