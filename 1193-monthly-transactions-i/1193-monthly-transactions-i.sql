select date_format(trans_date, '%Y-%m') AS month,
    country,
    count(*) AS trans_count,
    sum(case when state = 'approved' then 1 else 0 end) AS approved_count,
    SUM(amount) AS trans_total_amount,
    SUM(CASE WHEN state = 'approved' THEN amount ELSE 0 END) AS approved_total_amount
FROM Transactions
GROUP BY month, country;