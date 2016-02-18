
select case
when p.team = 'O' then 'Offense'
when p.team = 'D' then 'Defense'
when p.team = 'S' then 'Special Teams' end as team, count(*)
from roster r, positions p
where r.position = p.position and r.stcode='IL' group by team;
