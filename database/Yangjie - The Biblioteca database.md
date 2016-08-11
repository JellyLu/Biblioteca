1.Who checked out the book 'The Hobbit’?  

select member.name from member  where member.id  in ( select checkout_item.member_id from checkout_item where checkout_item.book_id in ( select book.id from  book where book.title = "The Hobbit"));

2.How many people have not checked out anything?

select count(*) from member where member.id not in (select checkout_item.member_id from checkout_item);


3.What books and movies aren't checked out?

select book.id, book.title from book where book.id  not in (select checkout_item.book_id from checkout_item);
select movie.id, movie.title from movie where movie.id  not in (select checkout_item.movie_id from checkout_item);


4.Add the book 'The Pragmatic Programmer', and add yourself as a member. Check out 'The Pragmatic Programmer'. Use your query from question 1 to verify that you have checked it out. Also, provide the SQL used to update the database.

insert into book (id, title) values (11, "The Pragmatic Programmer");
insert into member (id, name) values (43, "Yangjie Lu");
insert into checkout_item (member_id, book_id) values (43, 11);
select * from member  where member.id  in ( select checkout_item.member_id from checkout_item where  checkout_item.book_id in ( select book.id from  book where book.title = "The Pragmatic Programmer"));

5.Who has checked out more that 1 item?
select checkout_item.member_id from checkout_item group by checkout_item.member_id having count(checkout_item.member_id) > 2;
