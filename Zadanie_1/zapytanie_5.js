printjson(
db.people.find(
	{
		birth_date: {
			$gte: ISODate('2001-01-01T00:00:00Z')
		}
	},
	{_id: false, first_name: true, last_name: true, location: {city: true}}
).toArray());