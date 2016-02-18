.mode column
.header on

select a.city, a.stcode, a.zip
from uszips a, 
(
  select *
  from uszips z
  where z.zip = 46637
) b
where a.stcode = b.stcode 
and a.city = b.city
;
