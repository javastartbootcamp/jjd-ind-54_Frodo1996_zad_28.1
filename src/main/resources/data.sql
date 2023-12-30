INSERT INTO category(id, name, description)
VALUES (1, 'Elektronika', 'Najlepsza elektronika na rynku'),
       (2, 'Meble', 'Meble do domu i ogrodowe');

INSERT INTO offer(title, description, img_url, price, category_id)
VALUES
    ('Telewizor',
     'Super telewizor o przekątnej 55 cali',
     'https://prod-api.mediaexpert.pl/api/images/gallery/thumbnails/images/56/5673424/Telewizor-PHILIPS-55PUS7008-skos-lewy.jpg',
     1299,
     1),
    ('Kino domowe',
     'Wypasione kino domowe firmy Sony, gra tak, że można robić festyn',
     'https://prod-api.mediaexpert.pl/api/images/gallery/thumbnails/images/12/1223483/1.JPG',
     699,
     1),
    ('Stół drewniany',
     'Idealny stół drewniany dla rodziny, 6 krzeseł gratis',
     'https://www.ikea.com/pl/pl/images/products/norrmansoe-stol-ogrodowy-akacja__1077697_pe856979_s5.jpg?f=xl',
     2699,
     2);