SELECT
    count_user AS PURCHASE_COUNT,
    ROUND(AVG(distance)) AS AVG_DISTANCE
FROM (
         SELECT
             user_id AS user_id,
             count(user_id) AS count_user,
             distance AS distance
         FROM purchases
                  INNER JOIN game_users ON purchases.user_id = game_users.id
         GROUP BY purchases.user_id
     ) grouping_user
GROUP BY count_user
ORDER BY count_user DESC
;