alter table craigslist.search_query add column url text not null;
alter table craigslist.search_query add column by_owner boolean not null;