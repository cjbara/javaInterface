.mode column
.header on

select position, 
	avg(case when year = 'FR' then a.w end) as 'FR',
	avg(case when year = 'SO' then a.w end) as 'SO',
	avg(case when year = 'JR' then a.w end) as 'JR',
	avg(case when year = 'SR' then a.w end) as 'SR',
	avg(case when year = 'GS' then a.w end) as 'GS'

from
(
  select position, year, avg(weight) as w
  from roster
  group by position, year
  order by 2 desc, 1
) a
group by position
order by 1
;
