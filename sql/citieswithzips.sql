select city, stcode, count(*) as z
from uszips
group by city, stcode
having z >= (select min(a) from (select count(*) as a from uszips group by city, stcode order by 1 desc limit 10))
order by 3 desc
;
