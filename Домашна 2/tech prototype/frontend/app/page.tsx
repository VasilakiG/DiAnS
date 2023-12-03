import { Button, HStack, Heading, VStack } from "@chakra-ui/react";

export default function Home() {
	return (
    	<>
			<div
				style={{
					backgroundImage: `url('/landingPhoto.png')`,
					backgroundRepeat: 'no-repeat',
					width: '100%',
					height: '90%',
					backgroundPosition: 'center',
					backgroundSize: '100%',
				}}
			>
				<HStack
					height="100%"
					width="100%"
					color={'white'}
					padding={'5%'}
				>
					<VStack
						padding="1vw"
						justifyContent="left"
						alignItems="left"
						width={'60vw'}
					>
						<Heading
							fontSize="5vw"
							fontWeight="bold"
							fontFamily={'Times New Roman'}
							textAlign="left"
						>
							MACEDONIA<br /> Timeless.
						</Heading>

						<Heading
							fontSize="1.3vw"
							fontWeight="bold"
							fontFamily={'Times New Roman'}
							textAlign="left"
						>
							Discover the enchanting beauty of Macedonia - where rich history meets breathtaking landscapes.
						</Heading>
					</VStack>

					<VStack
						justifyContent="left"
						alignItems="bottom"
						paddingTop={"55vh"}
						paddingLeft={"15vw"}
					>
						<Button
							paddingLeft={'7vh'}
							paddingTop={'3vh'}
							paddingRight={'7vh'}
							paddingBottom={'3vh'}
							fontSize={'2vh'}
							fontWeight={'bold'}
							color={'white'}
							backgroundColor={"#5DB3FF"}	
						>
							EXPLORE
						</Button>
					</VStack>
				</HStack>

			</div>
    	</>
	);
};
