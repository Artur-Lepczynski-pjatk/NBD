printjson(
db.people.aggregate([
	{
		$addFields: {
			BMI: {$divide: ['$weight', {$multiply: [{$divide: ['$height', 100]}, {$divide: ['$height', 100]}]}]}
		}
	},
	
	{
		$group: {
			_id: '$nationality',
			średnieBMI: {$avg: '$BMI'},
			minimalneBMI: {$min: '$BMI'},
			maksymalneBMI: {$max: '$BMI'}
		}
	}
]).toArray());