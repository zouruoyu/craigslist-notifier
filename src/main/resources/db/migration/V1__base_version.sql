create table craigslist.search_query (
  id serial not null primary key,
  keyword text not null,
  min_price text,
  max_price text,
  created_at timestamp with time zone not null,
  updated_at timestamp with time zone not null
);

create table craigslist.search_result (
  id serial not null primary key,
  title text not null,
  description text not null,
  price decimal not null,
  search_query_id smallint references craigslist.search_query(id),
  posted_time timestamp with time zone not null,
  created_at timestamp with time zone not null
);

