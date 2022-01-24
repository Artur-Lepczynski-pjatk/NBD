printjson(
db.people.aggregate([
	{
		$group: {
			  _id: '$sex',
			  totalWeight: {$sum: '$weight'},
			  totalHeight: {$sum: '$height'},
			  total: {$sum: 1}
		}
	},
	
	{
		$project: {
			averageWeight: {
				$divide: ['$totalWeight', '$total']
			},
			averageHeight: {
				$divide: ['$totalHeight', '$total']
			}
		}
	}
]).toArray());