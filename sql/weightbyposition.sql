.header on
.mode column

select position, printf("%.2f",avg(weight)) as avgWeight
from roster
group by position
order by 2 desc, 1
;
