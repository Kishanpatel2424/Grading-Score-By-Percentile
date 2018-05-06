/*
 * This Program is used for assigning scores based of overall class scores
 * 
 * All scores are divided into 20% percentile and the scores are assigned accordingly
 * 
 * top 20% of scores are A
 * next 20% of scores are B
 * next 20% of scores are C
 * next 20% of scores are D
 * next 20% of scores are F
 * 
 * At first it creates a sorted list which is saved into scores which is passed to findDublicate function which returns 
 * scores with no dublicate
 * then a scoresDublicate list is created to save the original values.
 * 
 *  Scores list is use to create a percentile index score because its sorted and no dublicate values 
 *  
 *  The percentile  index scores are saved into an array
 *  Get Scores
	 * Prints the Sorted array with non dublicate Value
	 * Prints the Sorted Original Array  
	 * 
	 * For loop to calculate 20% of all scores and saves the srarting socre for each 20% into an indexValue array
	 * 
	 * For loop of scoresDublicate assign the value grade 
 *  
 * 
 * STEP 1
 *   Please input number of scores 
 *   OR
 *   Use a list of scores prefered 0-100
 */
