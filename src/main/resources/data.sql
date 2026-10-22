-- Example shows loaded on every startup. Edit this file to change the data the API returns.
INSERT INTO shows (id, title, performer, category, venue, city, starts_at, starting_price, currency) VALUES
    ('neon-harbor-electric-tides-sao-paulo', 'Electric Tides Tour', 'Neon Harbor', 'CONCERT',
     'Harbor Arena', 'São Paulo', TIMESTAMP WITH TIME ZONE '2026-11-28 21:00:00-03:00', 180.00, 'BRL'),
    ('the-last-act-rio', 'The Last Act', 'Aurora Theater Company', 'THEATER',
     'Aurora Theater', 'Rio de Janeiro', TIMESTAMP WITH TIME ZONE '2026-12-05 20:00:00-03:00', 120.00, 'BRL'),
    ('laugh-track-belo-horizonte', 'Laugh Track', 'The Punchline Collective', 'STAND_UP_COMEDY',
     'Central Stage', 'Belo Horizonte', TIMESTAMP WITH TIME ZONE '2026-12-12 22:00:00-03:00', 80.00, 'BRL'),
    ('summer-sound-festival-2027', 'Summer Sound Festival 2027', 'Various Artists', 'FESTIVAL',
     'Beira-Mar Park', 'Florianópolis', TIMESTAMP WITH TIME ZONE '2027-01-16 14:00:00-03:00', 350.00, 'BRL');
