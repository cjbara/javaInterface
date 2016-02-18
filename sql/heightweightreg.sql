.mode column
.header on

select region, avg(height_ft*12 + height_in) as avgheight, avg(weight) as avgweight
from roster r, streg s, regions reg
where r.stcode = s.stcode
and reg.regcode = s.regcode
group by s.regcode
order by 2 desc, 3 desc, 1
;
