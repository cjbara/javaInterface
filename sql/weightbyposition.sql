.header on
.mode column

select position, avg(weight) as avgWeight
from roster
group by position
order by 2 desc, 1
;
