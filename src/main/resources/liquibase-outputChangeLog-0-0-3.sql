alter table ecommerce.product add column url varchar;

update ecommerce.product set url = 'http://freeiconshop.com/wp-content/uploads/edd/android-flat.png' where url is null;