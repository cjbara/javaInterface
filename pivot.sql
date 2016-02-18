.header on
.mode column

select b.city as CITY, b.total as FREQ, 
  sum(case when b.regcode = 1 then b.regcount end) as 'Northeast',
  sum(case when b.regcode = 2 then b.regcount end) as 'Midwest',
  sum(case when b.regcode = 3 then b.regcount end) as 'Southeast',
  ifnull(sum(case when b.regcode = 4 then b.regcount end), 0) as 'Southwest',
  sum(case when b.regcode = 5 then b.regcount end) as 'West'
from (
  select a.city, a.total, regcode, count(distinct z.stcode) regcount
  from (
    select city, count(distinct z.stcode) as total
    from uszips z
    group by city
    order by 2 desc, 1
    limit 10
  ) a, streg s, uszips z
  where z.stcode = s.stcode
  and z.city = a.city
  group by a.city, regcode
  order by 2 desc, 1
) b
group by city
order by 2 desc, 1
;
