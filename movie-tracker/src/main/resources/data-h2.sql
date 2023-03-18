WITH T(video_id, video_type, en_title, localized_title, "year")  AS (
	SELECT * FROM
	VALUES
    ('MOV-001', 'MOVIE', 'Star Wars', 'Звёздные войны: Эпизод 4 — Новая надежда', 1977),
    ('MOV-002', 'MOVIE', 'The Lovely Bones', 'Милые кости', 2009),
    ('MOV-003', 'MOVIE', 'Into the Wild', 'В диких условиях', 2007)
)
INSERT INTO video_content
    (video_id, video_type, en_title, localized_title, "year")
SELECT video_id, video_type, en_title, localized_title, "year" FROM t
WHERE NOT EXISTS (SELECT 1 FROM video_content WHERE video_id = t.video_id);