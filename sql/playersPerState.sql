.mode column
.header on
.width 15

select s.state as STATE, count(*) as PLAYERS
from states s left outer join roster r
on s.stcode = r.stcode
group by r.stcode
order by 2 desc, 1
;
