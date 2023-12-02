import type { Metadata } from 'next'
import { Inter } from 'next/font/google'
import './globals.css'
import { Button, ChakraProvider, HStack, Text, VStack } from '@chakra-ui/react'
import Image from 'next/image'
import Link from 'next/link'

const inter = Inter({ subsets: ['latin'] })

export const metadata: Metadata = {
	title: 'MacedoniaTimeless',
	description: 'Веб апликација [MacedoniaTimeless] дизајнирана за мапирање на податоци со отворен код и пронаоѓање на оптимални рути, за културно-историски објекти во Македонија. Изработена како дел од факултетски курс.',
}

export default function RootLayout({
	children,
}: {
	children: React.ReactNode
}) {
	return (
		<ChakraProvider>
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
					spacing="5vw"
				>
					<Link
						href="/"
						color='black'
					>
						News
					</Link>

					<Link
						href="/"
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
			<body className={inter.className}>{children}</body>
    	</ChakraProvider>
	);
};
