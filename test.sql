
select count(1) from news where nauthor='news'
select * from news_users
select * from topic
select * from comments
select * from sysdiagrams
select count(1) count from news
select top 3 nauthor,nid from news 
where nid not in (select top 3 nid from news)