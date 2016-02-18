.header on
.mode column

select r.region, count(*)
from regions r, streg s
where r.regcode = s.regcode
group by r.region
order by 2 desc, 1
;
