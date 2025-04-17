insert into colors (id, hex, name)
values (1, '0071e3', 'Ultramarine');
insert into colors (id, hex, name)
values (2, 'F3B5DE', 'Pink');

insert into products (id, sku, brand, model, amount)
values (1, 'AI16P', 'Apple', 'IPhone16Plus', 1200);
insert into products (id, sku, brand, model, amount)
values (2, 'AI16', 'Apple', 'IPhone16', 900);

insert into product_color (description, color_id, product_id)
values ('', 1, 1);
insert into product_color (description, color_id, product_id)
values ('', 2, 1);
insert into product_color (description, color_id, product_id)
values ('', 1, 2);