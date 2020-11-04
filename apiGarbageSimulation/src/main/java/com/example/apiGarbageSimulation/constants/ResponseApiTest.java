package com.example.apiGarbageSimulation.constants;

public class ResponseApiTest {
	
	public static final String RESPONSE = "{\r\n" + 
			"    \"code\": 0,\r\n" + 
			"    \"summary\": {\r\n" + 
			"        \"cost\": 892,\r\n" + 
			"        \"unassigned\": 8,\r\n" + 
			"        \"delivery\": [\r\n" + 
			"            37478\r\n" + 
			"        ],\r\n" + 
			"        \"amount\": [\r\n" + 
			"            37478\r\n" + 
			"        ],\r\n" + 
			"        \"pickup\": [\r\n" + 
			"            0\r\n" + 
			"        ],\r\n" + 
			"        \"service\": 15000,\r\n" + 
			"        \"duration\": 892,\r\n" + 
			"        \"waiting_time\": 0,\r\n" + 
			"        \"computing_times\": {\r\n" + 
			"            \"loading\": 123,\r\n" + 
			"            \"solving\": 76\r\n" + 
			"        }\r\n" + 
			"    },\r\n" + 
			"    \"unassigned\": [\r\n" + 
			"        {\r\n" + 
			"            \"id\": 54,\r\n" + 
			"            \"location\": [\r\n" + 
			"                -74.13529,\r\n" + 
			"                4.7109876\r\n" + 
			"            ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"id\": 49,\r\n" + 
			"            \"location\": [\r\n" + 
			"                -74.13473,\r\n" + 
			"                4.7125635\r\n" + 
			"            ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"id\": 40,\r\n" + 
			"            \"location\": [\r\n" + 
			"                -74.13525,\r\n" + 
			"                4.711788\r\n" + 
			"            ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"id\": 16,\r\n" + 
			"            \"location\": [\r\n" + 
			"                -74.13624,\r\n" + 
			"                4.712783\r\n" + 
			"            ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"id\": 12,\r\n" + 
			"            \"location\": [\r\n" + 
			"                -74.1356,\r\n" + 
			"                4.7122416\r\n" + 
			"            ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"id\": 1,\r\n" + 
			"            \"location\": [\r\n" + 
			"                -74.135826,\r\n" + 
			"                4.7120643\r\n" + 
			"            ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"id\": 31,\r\n" + 
			"            \"location\": [\r\n" + 
			"                -74.13538,\r\n" + 
			"                4.710688\r\n" + 
			"            ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"id\": 32,\r\n" + 
			"            \"location\": [\r\n" + 
			"                -74.13541,\r\n" + 
			"                4.7120275\r\n" + 
			"            ]\r\n" + 
			"        }\r\n" + 
			"    ],\r\n" + 
			"    \"routes\": [\r\n" + 
			"        {\r\n" + 
			"            \"vehicle\": 1,\r\n" + 
			"            \"cost\": 892,\r\n" + 
			"            \"delivery\": [\r\n" + 
			"                37478\r\n" + 
			"            ],\r\n" + 
			"            \"amount\": [\r\n" + 
			"                37478\r\n" + 
			"            ],\r\n" + 
			"            \"pickup\": [\r\n" + 
			"                0\r\n" + 
			"            ],\r\n" + 
			"            \"service\": 15000,\r\n" + 
			"            \"duration\": 892,\r\n" + 
			"            \"waiting_time\": 0,\r\n" + 
			"            \"steps\": [\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"start\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13774,\r\n" + 
			"                        4.7122636\r\n" + 
			"                    ],\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        37478\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 0,\r\n" + 
			"                    \"duration\": 0\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13756,\r\n" + 
			"                        4.7125416\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 3,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 3,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        36414\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 8,\r\n" + 
			"                    \"duration\": 8\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.138306,\r\n" + 
			"                        4.7119875\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 22,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 22,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        36036\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 333,\r\n" + 
			"                    \"duration\": 33\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.1387,\r\n" + 
			"                        4.711884\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 37,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 37,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        35392\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 646,\r\n" + 
			"                    \"duration\": 46\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.139015,\r\n" + 
			"                        4.712174\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 47,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 47,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        34734\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 958,\r\n" + 
			"                    \"duration\": 58\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.139046,\r\n" + 
			"                        4.7124615\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 23,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 23,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        34342\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 1269,\r\n" + 
			"                    \"duration\": 69\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13882,\r\n" + 
			"                        4.7126102\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 18,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 18,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        33250\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 1576,\r\n" + 
			"                    \"duration\": 76\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13879,\r\n" + 
			"                        4.712327\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 7,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 7,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        32144\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 1887,\r\n" + 
			"                    \"duration\": 87\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13853,\r\n" + 
			"                        4.711646\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 9,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 9,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        31332\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 2207,\r\n" + 
			"                    \"duration\": 107\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.138145,\r\n" + 
			"                        4.7117505\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 6,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 6,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        30464\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 2515,\r\n" + 
			"                    \"duration\": 115\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.137924,\r\n" + 
			"                        4.7115455\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 27,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 27,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        29610\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 2839,\r\n" + 
			"                    \"duration\": 139\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13754,\r\n" + 
			"                        4.7112756\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 42,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 42,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        28602\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 3155,\r\n" + 
			"                    \"duration\": 155\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13728,\r\n" + 
			"                        4.710922\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 50,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 50,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        28042\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 3467,\r\n" + 
			"                    \"duration\": 167\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.1359,\r\n" + 
			"                        4.7106934\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 41,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 41,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        27272\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 3847,\r\n" + 
			"                    \"duration\": 247\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13655,\r\n" + 
			"                        4.711173\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 45,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 45,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        27048\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 4167,\r\n" + 
			"                    \"duration\": 267\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13687,\r\n" + 
			"                        4.7117553\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 8,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 8,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        26264\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 4485,\r\n" + 
			"                    \"duration\": 285\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13701,\r\n" + 
			"                        4.7120237\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 51,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 51,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        25060\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 4793,\r\n" + 
			"                    \"duration\": 293\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13705,\r\n" + 
			"                        4.7127366\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 21,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 21,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        23996\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 5112,\r\n" + 
			"                    \"duration\": 312\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13669,\r\n" + 
			"                        4.7131724\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 33,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 33,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        23688\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 5429,\r\n" + 
			"                    \"duration\": 329\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.1363,\r\n" + 
			"                        4.713347\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 55,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 55,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        23114\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 5745,\r\n" + 
			"                    \"duration\": 345\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.136246,\r\n" + 
			"                        4.7130027\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 57,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 57,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        22666\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 6084,\r\n" + 
			"                    \"duration\": 384\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.1367,\r\n" + 
			"                        4.713533\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 56,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 56,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        21994\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 6432,\r\n" + 
			"                    \"duration\": 432\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13704,\r\n" + 
			"                        4.713444\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 53,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 53,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        20762\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 6746,\r\n" + 
			"                    \"duration\": 446\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13767,\r\n" + 
			"                        4.7128367\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 19,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 19,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        19754\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 7064,\r\n" + 
			"                    \"duration\": 464\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.138145,\r\n" + 
			"                        4.7130566\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 34,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 34,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        19180\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 7382,\r\n" + 
			"                    \"duration\": 482\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13835,\r\n" + 
			"                        4.712634\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 48,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 48,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        18060\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 7700,\r\n" + 
			"                    \"duration\": 500\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13811,\r\n" + 
			"                        4.7125154\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 2,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 2,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        17360\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 8007,\r\n" + 
			"                    \"duration\": 507\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13833,\r\n" + 
			"                        4.712356\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 58,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 58,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        17220\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 8309,\r\n" + 
			"                    \"duration\": 509\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13854,\r\n" + 
			"                        4.712196\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 13,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 13,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        17024\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 8611,\r\n" + 
			"                    \"duration\": 511\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.138954,\r\n" + 
			"                        4.7118864\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 4,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 4,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        16240\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 8916,\r\n" + 
			"                    \"duration\": 516\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13917,\r\n" + 
			"                        4.711734\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 26,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 26,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        15638\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 9218,\r\n" + 
			"                    \"duration\": 518\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13923,\r\n" + 
			"                        4.7120113\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 43,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 43,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        14700\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 9525,\r\n" + 
			"                    \"duration\": 525\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.139496,\r\n" + 
			"                        4.7121644\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 38,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 38,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        14056\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 9837,\r\n" + 
			"                    \"duration\": 537\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13946,\r\n" + 
			"                        4.7118616\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 17,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 17,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        13664\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 10144,\r\n" + 
			"                    \"duration\": 544\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.139404,\r\n" + 
			"                        4.711567\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 15,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 15,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        13300\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 10449,\r\n" + 
			"                    \"duration\": 549\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.14023,\r\n" + 
			"                        4.711471\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 39,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 39,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        12502\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 10758,\r\n" + 
			"                    \"duration\": 558\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.14019,\r\n" + 
			"                        4.7117114\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 52,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 52,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        11942\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 11063,\r\n" + 
			"                    \"duration\": 563\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.14039,\r\n" + 
			"                        4.711741\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 29,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 29,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        11116\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 11367,\r\n" + 
			"                    \"duration\": 567\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.1406,\r\n" + 
			"                        4.711753\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 46,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 46,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        10038\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 11673,\r\n" + 
			"                    \"duration\": 573\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.140564,\r\n" + 
			"                        4.711429\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 20,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 20,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        9212\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 12000,\r\n" + 
			"                    \"duration\": 600\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.14094,\r\n" + 
			"                        4.7123113\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 44,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 44,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        8470\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 12341,\r\n" + 
			"                    \"duration\": 641\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.14013,\r\n" + 
			"                        4.712886\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 25,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 25,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        7462\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 12658,\r\n" + 
			"                    \"duration\": 658\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.138855,\r\n" + 
			"                        4.713649\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 5,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 5,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        7014\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 12978,\r\n" + 
			"                    \"duration\": 678\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13797,\r\n" + 
			"                        4.714024\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 10,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 10,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        6048\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 13314,\r\n" + 
			"                    \"duration\": 714\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.137794,\r\n" + 
			"                        4.7138047\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 11,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 11,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        5152\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 13621,\r\n" + 
			"                    \"duration\": 721\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.137215,\r\n" + 
			"                        4.7137246\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 36,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 36,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        4368\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 13942,\r\n" + 
			"                    \"duration\": 742\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.137634,\r\n" + 
			"                        4.713577\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 28,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 28,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        3486\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 14256,\r\n" + 
			"                    \"duration\": 756\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13816,\r\n" + 
			"                        4.713388\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 35,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 35,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        2436\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 14567,\r\n" + 
			"                    \"duration\": 767\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13896,\r\n" + 
			"                        4.712853\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 30,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 30,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        1442\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 14880,\r\n" + 
			"                    \"duration\": 780\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.139885,\r\n" + 
			"                        4.71225\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 24,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 24,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        532\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 15195,\r\n" + 
			"                    \"duration\": 795\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"type\": \"job\",\r\n" + 
			"                    \"location\": [\r\n" + 
			"                        -74.13907,\r\n" + 
			"                        4.714004\r\n" + 
			"                    ],\r\n" + 
			"                    \"id\": 14,\r\n" + 
			"                    \"service\": 300,\r\n" + 
			"                    \"waiting_time\": 0,\r\n" + 
			"                    \"job\": 14,\r\n" + 
			"                    \"load\": [\r\n" + 
			"                        0\r\n" + 
			"                    ],\r\n" + 
			"                    \"arrival\": 15592,\r\n" + 
			"                    \"duration\": 892\r\n" + 
			"                }\r\n" + 
			"            ]\r\n" + 
			"        }\r\n" + 
			"    ]\r\n" + 
			"}\r\n" + 
			"";

}
