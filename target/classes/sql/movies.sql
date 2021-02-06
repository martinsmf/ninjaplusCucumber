TRUNCATE TABLE PUBLIC.MOVIES RESTART IDENTITY;

INSERT INTO public.movies(
  title, status, year, release_date,
  "cast", overview, cover, created_at,
  updated_at
)
VALUES
  (
    'Batman Begins', 'Disponível', 2005,
    '10/10/2005', '{"Christian Bale","Michael Caine","Morgan Freeman"}',
    'O jovem Bruce Wayne viaja para o Extremo Oriente, onde recebe treinamento em artes marciais do mestre Henri Ducard.',
    'begins.jpg', current_timestamp,
    current_timestamp
  );
INSERT INTO public.movies(
  title, status, year, release_date,
  "cast", overview, cover, created_at,
  updated_at
)
VALUES
  (
    'Batman O Cavaleiro das Trevas',
    'Disponível', 2008, '10/10/2005',
    '{"Christian Bale","Michael Caine","Morgan Freeman"}',
    'Com a ajuda de Jim Gordon e Harvey Dent, Batman tem mantido a ordem na cidade de Gotham.',
    'dark_knight.jpg', current_timestamp,
    current_timestamp
  );
INSERT INTO public.movies(
  title, status, year, release_date,
  "cast", overview, cover, created_at,
  updated_at
)
VALUES
  (
    'Clube da luta', 'Disponível',
    1999, '10/10/2000', 
	'{"Brad Pit","Edward Norton","Marla"}',
    'Um homem deprimido que sofre de insônia.',
    'clube.jpg', current_timestamp,
    current_timestamp
  );
INSERT INTO public.movies(
  title, status, year, release_date,
  "cast", overview, cover, created_at,
  updated_at
)
VALUES
  (
    'Coringa', 'Em breve', 2019, '01/12/2020',
    '{"Joaquin Phoenix","Robert De Niro"}',
    'O comediante falido Arthur Fleck encontra violentos bandidos pelas ruas de Gotham City.',
    'coringa.jpg', current_timestamp,
    current_timestamp
  );
INSERT INTO public.movies(
  title, status, year, release_date,
  "cast", overview, cover, created_at,
  updated_at
)
VALUES
  (
    'Deadpool 2', 'Disponível', 2018,
    '01/05/2018', '{"Ryan Reynolds","Josh Brolin"}',
    'O supersoldado Cable vem do futuro com a missão de detonar um jovem mutante e o Deadpool deve salvá-lo.',
    'dp2.jpg', current_timestamp, current_timestamp
  );