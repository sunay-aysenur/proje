SELECT TOP 1 m.id, m.name, m.release_year, m.price, m.category_id, m.type, AVG(s.score) AS avg_score
FROM Material m
JOIN Score s ON m.id = s.material_id
GROUP BY m.id, m.name, m.release_year, m.price, m.category_id, m.type
ORDER BY avg_score DESC;
