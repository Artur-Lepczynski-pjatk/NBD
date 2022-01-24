printjson(
db.people.aggregate([
	{
		$match: {sex: 'Female', nationality: 'Poland'}
	},
	
	{
		$unwind: {
			path: '$credit'
		}
	},
	
	{
		$group: {
			_id: '$credit.currency',
			średnia: {$avg: '$credit.balance'},
			suma: {$sum: '$credit.balance'}
		}
	}
]).toArray());