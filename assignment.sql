SELECT
    td.user_id,
    u.username,
    td.training_id,
    td.training_date,
    COUNT(*) AS training_count
FROM
    Training_details td
        JOIN
    User_ u ON td.user_id = u.user_id
GROUP BY
    td.user_id, u.username, td.training_id, td.training_date
HAVING
    COUNT(*) > 1
ORDER BY
    td.training_date DESC