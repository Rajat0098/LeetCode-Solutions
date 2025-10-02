SELECT id, num
FROM (
    SELECT id, COUNT(DISTINCT friend) AS num
    FROM (
        SELECT requester_id AS id, accepter_id AS friend
        FROM RequestAccepted
        UNION ALL
        SELECT accepter_id AS id, requester_id AS friend
        FROM RequestAccepted
    ) t
    GROUP BY id
) x
ORDER BY num DESC, id ASC
LIMIT 1;
