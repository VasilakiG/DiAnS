import { Button, HStack } from '@chakra-ui/react'
import Image from 'next/image'
import Link from 'next/link'
import { useRouter } from 'next/router';

const HeaderPC = () =>{

	const router = useRouter();

	const isHomePage = router.pathname === "/";

	const handleNewsClick = () => {
		router.push("/");
	};

	const handleMapClick = () => {
		router.push("/map");
	};

	const handleAboutClick = () => {
		router.push("/about-us");
	};
	
	return (
		<HStack
			bg="white"
			color="black"
			h="10vh"
			w="100%"
			justify="space-between"
			p={"1vw"}
		>
			<Image
				src="/logo.png"
				alt="MacedoniaTimeless"
				width="70" 
				height="70"
			/>

			<HStack
				paddingTop={"1vh"}
				spacing="7.5vw"
				fontSize={'1vw'}
			>
				<Link
					href="/"
					color='black'
				>
					News
				</Link>

				<Link
					href="/map"
					color='black'
				>
					Map
				</Link>

				<Link
					href="/"
					color='black'
				>
					About
				</Link>
			</HStack>

			<HStack
				spacing="1vw"
				paddingRight={"1vw"}
			>
				<Button
					background="#5DB3FF"
					color={"white"}
				>
					Sign in
				</Button>
				<Button
					background="white"
					color="#5DB3FF"
					border={"3px solid #5DB3FF80"}
				>
					Sign up
				</Button>
			</HStack>
		</HStack>
	);
};

export default HeaderPC;